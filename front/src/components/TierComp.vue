<template>
<div id="container">
    <div v-for="(item, idx) in lists" :key="item.id">
        <div class="col" @drop.prevent="onDrop($event, idx)" @dragenter.prevent @dragover.prevent>
            <div class="grade-box">
                            {{item.id}}
            </div>

            <div v-for="(numItem, idx) in item.numberList" :key="idx" class="box" @dragstart="startDrag($event, numItem, item.id)" draggable="true">
                <p>{{ numItem.content }}</p>
            
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name: "TierComp",
    data() {
        return {
            lists: [{
                    id: "S",
                    numberList: [{
                        content: "나의 아저씨"
                    }, {
                        content: "미스터 션샤인"
                    }]
                },
                {
                    id: "A",
                    numberList: [{
                        content: "비밀의 숲"
                    }, {
                        content: "소년시대"
                    }, {
                        content: "동백꽃필무렵"
                    }, {
                        content: "스카이캐슬"
                    }]
                },
                {
                    id: "B",
                    numberList: [{
                        content: "내남편과결혼해줘"
                    }, {
                        content: "재벌집막내아들"
                    }, {
                        content: "슈룹"
                    }]
                },
                {
                    id: "C",
                    numberList: [{
                        content: "스토브리그"
                    }, {
                        content: "악인"
                    }, {
                        content: "용"
                    }]
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

            // drop이 된 <div> index(=colNum)를 받아 리스트에 추가한다. 
            // 기존 리스트에서는 요소를 삭제한다. (splice() 사용)
            this.lists[colNum].numberList.push(targetItem)
            this.lists[targetIdx].numberList.splice(this.lists[targetIdx].numberList.indexOf(targetItem), 1)
        },
    },
};
</script>

<style>
@import "../css/comp-tier.css"
</style>
