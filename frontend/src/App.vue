<script>
import GameMap from './components/GameMap.vue'
import GamePanel from "@/components/GamePanel.vue";
import HelpPanel from "@/components/HelpPanel.vue";
export default {
  components: {
    GameMap,
    GamePanel,
    HelpPanel
  },
  data() {
    return {
      map:{
        newPlayer:[5,5],
        load:false,
        loadMsg:"正在切换房间"
      },
      game:{
        name:"大厅",
        info:"这是游戏的大厅",
        items:["二向箔","碧石"]
      },
      help:{
        tracks:['大厅']
      }
    }
  },
  methods:{
  }
}

</script>

<template>
<div id="game">
  <el-container class="all">
    <!-- 定义一个顶栏 -->
    <el-header>
      ZUUL
    </el-header>
    <!-- 嵌套的容器 -->
    <el-container class="middle">
      <!-- 定义内容栏 -->
      <el-main>
        <div class="rowa">
          <game-map v-bind="map" />
          <game-panel v-bind="game" />
        </div>
        <div class="rowb">
          <help-panel v-bind="help" />
        </div>
      </el-main>
    </el-container>
    <el-footer>&copy;WHUT</el-footer>
  </el-container>
</div>
</template>

<style scoped>
#game{
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  border: 2px solid red;
  flex-wrap: nowrap;
}
.el-container {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  border: 2px solid red;
  width: 90vw;
  border: 2px solid red;
}
.all{
  flex-direction: column;
  justify-content: flex-start;
  height: 100vh;
}
.middle{
  height: 90vh;
}

/* 顶栏的样式 */
.el-header{
  background: #f55f5f;
  color: aliceblue;
  height: 5vh;
  width: 100%;
  text-align: center;
}
/* 内容栏样式 */
.el-main{
  height: 90vh;
  width:100%;
  flex-direction: row;
  justify-content: center;
  flex-wrap: nowrap;
  background-color: rgb(122, 240, 185);
  color: aliceblue;
  border: 5px solid #ccc;
}
.rowa{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.rowb{
  display: flex;
  align-items: center;
  justify-content: center;
}
.el-footer{
  background-color: rgb(153, 146, 146);
  color: aliceblue;
  height: 5vh;
  width: 100%;
  text-align: center;
}


</style>
