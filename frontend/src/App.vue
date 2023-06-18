<!--
* @FileDescription: vue应用主页
-->
<script>
import GameMap from './components/GameMap.vue'
import GamePanel from "@/components/GamePanel.vue";
import HelpPanel from "@/components/HelpPanel.vue";
import axios from 'axios'
import {ElMessage} from "element-plus";
export default {
  components: {
    GameMap,
    GamePanel,
    HelpPanel
  },
  data() {
    return {
      map:{
        //分别为Map组件中玩家新位置,是否加载,加载提示
        newPlayer:[5,5],
        load:false,
        loadMsg:"正在切换房间"
      },
      game:{
        //分别为游戏面板的房间名称,介绍,物品列表
        name:"起点",
        info:"这是游戏的起点",
        items:["新手教程"]
      },
      help:{
        //提示面板中存储的轨迹
        tracks:['起点']
      },
    }
  },
  methods:{
    /**
     * 显示一个消息提示框,type为类型,msg为内容
     * @param type
     * @param msg
     */
    showMsg(type,msg){
      ElMessage({
        message: msg,
        type: type,
      })
    },
    /**
     * 根据操作类型为玩家切换房间并更新信息
     * @param user 玩家新坐标
     * @param data 移动方向:-1为回退,0,1,2,3分别表示东西南北
     * @param msg 切换成功后返回的消息
     */
    move(user,data,msg){
      this.map.loadMsg=data==-1?'正在返回房间':'正在切换房间'
      this.map.load=true;
      axios({
        method: data==-1?'get':'post',
        url: '/api/move',
        data: {
          type:data
        },
        timeout: 1000,
      }).then(res=>{
        if(res.data.flag){
          this.refreshItems();
          this.showMsg('success',msg);
          this.help.tracks.push(res.data.data);
          if(this.help.tracks.length>=9){
            this.help.tracks.shift();
          }
          this.map.newPlayer=user;
          this.game.name=res.data.data;
          this.game.info="这是"+res.data.data+"的介绍";
        }
        else{
          this.showMsg('error',res.data.msg);
        }
      })
          .catch(err=>{
            console.log(err);
            this.showMsg("error",err);
          })
          .finally(
              err=>{
                this.map.load=false;
              }
          )

    },
    /**
     * 刷新当前房间的物品信息,在切换房间时触发
     */
    refreshItems(){
      axios.get('/api/bag/look')
          .then(res=>{
            if(res.data.flag){
              this.game.items=[];
              res.data.data.forEach(item=>{
                this.game.items.push(item.name);
              })
            }
            else{
              this.showMsg('error',res.data.msg);
            }
          })
          .catch(err=>{
            this.showMsg('error',err);
          })
    },
    /**
     * 接收子组件的移动事件并处理
     * @param dir 移动方向
     * @param backN 回退步数(可选)
     */
    handleGo(dir,backN){
      let type = -1;
      let user=[];
      let msg="";
      switch (dir) {
        case 'east':
          type=0;
          user=[5,1];
          msg="成功向东移动!"
          break;
        case 'west':
          type=1;
          user=[5,9];
          msg="成功向西移动!"
          break;
        case 'south':
          type=2;
          user=[1,5];
          msg="成功向南移动!"
          break;
        case 'north':
          type=3;
          user=[9,5];
          msg="成功向北移动!"
          break;
        case 'back':
          user=[5,5];
          msg="成功回退"+backN+"步!"
      }
      this.move(user,type,msg);
    }
  },
  /**
   * 挂载后初始化游戏
   */
  mounted() {
    axios.get('/api/initGame')
        .then(res=>{
          if(res.data.flag){
            this.showMsg('success','初始化游戏成功');
          }
          else{
            this.showMsg('error',res.data.msg);
          }
        })
        .catch(err=>{
          this.showMsg('error',err);
        })
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
          <game-map v-bind="map" @go="handleGo"/>
          <game-panel v-bind="game" />
        </div>
        <div class="rowb">
          <help-panel v-bind="help" @go="handleGo"/>
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
