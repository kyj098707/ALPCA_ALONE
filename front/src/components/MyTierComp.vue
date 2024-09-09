<template>
<div id="container">
    <div class="col-wrapper" v-for="(item, idx) in lists" :key="item.id">
        <div class="col" @drop.prevent="onDrop($event, idx)" @dragenter.prevent @dragover.prevent="onDragOver">
            <div class="grade-box">
                <img class="tier-imgae" :src="item.image_url">
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

<script>
import axios from "axios";
import FloatingButton from "./FloatingButton.vue";
import AddModal from "./AddModal.vue";

export default {
    name: "TierComp",
    components: {
        FloatingButton,
        AddModal,
    },
    props: {
        products: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            showModal: false,
            lists: [{
                    image_url: "img/stier.png",
                    numberList: []
                },
                {
                    image_url: "img/atier.png",
                    numberList: []
                },
                {
                    image_url: "img/btier.png",
                    numberList: []
                },
                {
                    image_url: "img/ctier.png",
                    numberList: []
                },
                {
                    image_url: "img/dtier.png",
                    numberList: []
                },
            ]
        };
    },
    methods: {
        startDrag(event, product) {
            this.draggedItem = product;
            event.dataTransfer.dropEffect = "move"
            event.dataTransfer.setData('text/plain', JSON.stringify(product));
        },

        onDragOver(event) {
            event.dataTransfer.dropEffect = 'move';
        },
        onDrop(event, targetIdx) {
            event.preventDefault();
            const itemData = JSON.parse(event.dataTransfer.getData('text/plain'));
            const sourceIdx = this.lists.findIndex(list =>
                list.numberList.some(item => item.id === itemData.id)
            );
            const sourceList = this.lists[sourceIdx];
            const targetItemIndex = sourceList.numberList.findIndex(item => item.id === itemData.id);
            if (targetItemIndex !== -1) {
                sourceList.numberList.splice(targetItemIndex, 1);
            }

            const targetList = this.lists[targetIdx];
            targetList.numberList.push(itemData);

            this.draggedItem = null;

        },
        createTier() {
            const tierData = {
                s: this.lists[0].numberList,
                a: this.lists[1].numberList,
                b: this.lists[2].numberList,
                c: this.lists[3].numberList,
                d: this.lists[4].numberList,
            };
            const token = localStorage.getItem('jwtToken');
            axios.post('http://localhost:8080/tier', tierData, {
                    headers: {
                        'Authorization': token
                    }
                })
                .then(response => {
                    console.log('티어표가 성공적으로 제작되었습니다:', response.data);
                    alert('티어표가 성공적으로 제작되었습니다.');
                })
                .catch(error => {
                    console.error('티어표 제작 중 오류가 발생했습니다:', error);
                    alert('티어표 제작 중 오류가 발생했습니다. 다시 시도해주세요.');
                });
        },

        fetchProduct() {
            const token = localStorage.getItem('jwtToken');
            if (!this.title) {
                this.message = "제목을 입력해주세요";
                return;
            }

            axios
                .get(`http://localhost:8080/product/search`, {
                    params: {
                        title: this.title
                    },
                    headers: {
                        'Authorization': token
                    }
                })
                .then((response) => {
                    this.message = `정상적으로 등록되었습니다: ${response.data.title}`;
                    this.lists[4].numberList.unshift(response.data);
                    this.title = "";
                    this.showModal = false;
                })
                .catch((error) => {
                    console.log(error)
                    alert("등록되지 않은 드라마입니다.")
                    this.message = "Error fetching product. Please try again.";
                });
        },
        closeModal() {
            this.showModal = false;
            this.message = "";
        },
    },
    mounted() {
        const token = localStorage.getItem('jwtToken');
        axios.get("http://localhost:8080/tier/me", {
                headers: {
                    'Authorization': token
                }
            })
            .then(response => {
                this.lists[0].numberList = response.data.s || [];
                this.lists[1].numberList = response.data.a || [];
                this.lists[2].numberList = response.data.b || [];
                this.lists[3].numberList = response.data.c || [];
                this.lists[4].numberList = response.data.d || [];
            })
            .catch(error => {
                console.log(error)
            })
    },
};
</script>

<style>
@import "../css/comp-tier.css"
</style>
