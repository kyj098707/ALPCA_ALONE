<template>
<div id="container">
    <div class="col-wrapper" v-for="(item, idx) in lists" :key="item.id">
        <div class="col" @drop.prevent="onDrop($event, idx)" @dragenter.prevent @dragover.prevent>
            <div class="grade-box">
                {{item.id}}
            </div>
            <div class="tier-content-box">
            <div v-for="(product, index) in item.numberList" :key="index" class="box" @dragstart="startDrag($event, product, index)" draggable="true">
    
                <img :src="product.imageUrl" class="box-image"> 
                <div class="content-box">{{ product.title }}</div>
            </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>

export default {
    name: "TierComp",
    props : {
                products: { 
                    type: Array,
                    required: true
                }
            },
    data() {
        return {
            prArray: [],
            
            lists: [{
                    id: "S",
                    numberList: []
                },
                {
                    id: "A",
                    numberList: []
                },
                {
                    id: "B",
                    numberList: []
                },
                {
                    id: "C",
                    numberList: [] 
                },{
                    id: "보관소",
                    numberList: this.products
                }
            ]
        };
    },
    methods: {
        startDrag(event, item) {
            event.dataTransfer.dropEffect = "move"
            event.dataTransfer.effectAllowed = "move"
            event.dataTransfer.setData("selectedItem", item.content)
        },
        onDrop(event, colNum) {
            const selectedItem = String(event.dataTransfer.getData("selectedItem"))

            let targetIdx
            let targetItem
            this.lists.forEach((obj, index) => {
                obj.numberList.forEach((ob) => {
                    if (ob.content === selectedItem) {
                        targetIdx = index
                        targetItem = ob
                    }
                })
            })

            this.lists[colNum].numberList.push(targetItem)
            this.lists[targetIdx].numberList.splice(this.lists[targetIdx].numberList.indexOf(targetItem), 1)
        },
        
    },
    mounted() {
            console.log(this.products)
        },
};
</script>

<style>
@import "../css/comp-tier.css"
</style>
