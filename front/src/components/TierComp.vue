<template>
<div id="container">
    <div class="col-wrapper" v-for="(item, idx) in lists" :key="item.id">
        <div class="col" @drop.prevent="onDrop($event, idx)" @dragenter.prevent @dragover.prevent="onDragOver">
            <div class="grade-box">
                {{item.id}}
            </div>
            <div class="tier-content-box">
                <div v-for="(product, index) in item.numberList" :key="product.id" class="box" @dragstart="startDrag($event, product, index)" draggable="true">
                    <img :src="product.imageUrl" class="box-image">
                    <div class="content-box">{{ product.title }}</div>
                </div>
            </div>
        </div>
    </div>

    <FloatingButton @open-modal="showModal = true" />

    <AddModal :visible="showModal" @close="closeModal">
        <div class="modal-content-wrapper">
            <h2 class="modal-title">드라마 추가하기</h2>
            <input v-model="title" type="text" placeholder="드라마 제목을 적어주세요" class="modal-input" />
            <button @click="fetchProduct" class="modal-button">등록하기</button>
            <p v-if="message" class="modal-message">{{ message }}</p>
        </div>
    </AddModal>

    <div>
        <button @click="createTier" id="create-tier-btn"> 티어표 제작하기 </button>
    </div>
</div>
</template>

<script setup>
import { ref, reactive, onMounted } from "vue";
import axios from "axios";
import FloatingButton from "./FloatingButton.vue";
import AddModal from "./AddModal.vue";

const showModal = ref(false);
const draggedItem = ref(null);
const title = ref("");
const message = ref("");

const lists = reactive([
  { id: "S", numberList: [] },
  { id: "A", numberList: [] },
  { id: "B", numberList: [] },
  { id: "C", numberList: [] },
  { id: "보관소", numberList: [] },
]);

const startDrag = (event, product) => {
  draggedItem.value = product;
  event.dataTransfer.dropEffect = "move";
  event.dataTransfer.setData("text/plain", JSON.stringify(product));
};

const onDragOver = (event) => {
  event.dataTransfer.dropEffect = "move";
};

const onDrop = (event, targetIdx) => {
  event.preventDefault();
  const itemData = JSON.parse(event.dataTransfer.getData("text/plain"));
  const sourceIdx = lists.findIndex(list =>
    list.numberList.some(item => item.id === itemData.id)
  );
  const sourceList = lists[sourceIdx];
  const targetItemIndex = sourceList.numberList.findIndex(item => item.id === itemData.id);

  if (targetItemIndex !== -1) {
    sourceList.numberList.splice(targetItemIndex, 1);
  }

  lists[targetIdx].numberList.push(itemData);
  draggedItem.value = null;
};

const createTier = () => {
  const tierData = {
    s: lists[0].numberList,
    a: lists[1].numberList,
    b: lists[2].numberList,
    c: lists[3].numberList,
    d: lists[4].numberList,
  };
  const token = localStorage.getItem("jwtToken");
  axios.post("http://localhost:8080/tier", tierData, {
    headers: {
      Authorization: token,
    },
  })
  .then((response) => {
    console.log("티어표가 성공적으로 제작되었습니다:", response.data);
    alert("티어표가 성공적으로 제작되었습니다.");
  })
  .catch((error) => {
    console.error("티어표 제작 중 오류가 발생했습니다:", error);
    alert("티어표 제작 중 오류가 발생했습니다. 다시 시도해주세요.");
  });
};

const fetchProduct = () => {
  const token = localStorage.getItem("jwtToken");
  if (!title.value) {
    message.value = "제목을 입력해주세요";
    return;
  }

  axios.get("http://localhost:8080/product/search", {
    params: { title: title.value },
    headers: { Authorization: token },
  })
  .then((response) => {
    message.value = `정상적으로 등록되었습니다: ${response.data.title}`;
    lists[4].numberList.unshift(response.data);
    title.value = "";
    showModal.value = false;
  })
  .catch((error) => {
    console.log(error);
    alert("등록되지 않은 드라마입니다.");
    message.value = "Error fetching product. Please try again.";
  });
};

const closeModal = () => {
  showModal.value = false;
  message.value = "";
};

onMounted(() => {
  const token = localStorage.getItem("jwtToken");
  axios.get("http://localhost:8080/product/defaulttier", {
    headers: { Authorization: token },
  })
  .then((response) => {
    lists[4].numberList = response.data;
  })
  .catch((error) => {
    console.log(error);
  });
});
</script>



<style>
@import "../css/comp-tier.css"
</style>
