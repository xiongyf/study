<template>
  <div id="todoList">
    <input class="item" v-model="inputValue"/>
    <button @click="submit">提交</button>
    <ul>
      <todo-item
        v-for="(item,index) in list"
        :key="index"
        :content="item"
        :index="index"
        @del="doDel"
      ></todo-item>
    </ul>
    <rank-list :list="rankList" :postFontSize=fontSize @onSelected="onListSelected"></rank-list>
  </div>
</template>

<script>
  import TodoItem from './TodoItem'
  import {mapActions} from 'vuex'
  import * as service from '../service/service'
  import RankList from './RankList'

  export default {
    name: "TodoList",
    components: {
      TodoItem,
      RankList
    },
    data() {
      return {
        inputValue: '',
        list: [],
        fontSize:1,
        rankList: [
          {
            name: 'Apple',
            value: '9',
            percentage: '20%'
          },
          {
            name: 'Li',
            value: '8',
            percentage: '20%'
          },
          {
            name: 'Mango',
            value: '6',
            percentage: '10%'
          }
        ]
      }
    },
    methods: {
      ...mapActions([
        'doIncrease',
        'doSetData'
      ]),
      submit() {
        if (this.inputValue) {
          this.list.push(this.inputValue);
          this.doIncrease();
          this.doSetData({
            msg: this.inputValue
          });
          this.add(this.inputValue);
          this.inputValue = '';
          this.currUser()
        }
      },
      doDel(index) {
        this.list.splice(index, 1)
      },
      add(msg) {
        service.addMsg(msg).then(function (resp) {
          console.log(resp.body.msg);
        })
      },
      currUser() {
        service.getCurrUser().then((resp) => {
          console.log(resp.body);
        })
      },
      onListSelected(item,index){
        console.log(item.name+' '+index)
      }
    },
    mounted() {
      document.onkeyup = (event) => {
        if (event.keyCode == 13 && this.$route.name == 'todoList') {
          this.submit();
        }
      }
    }
  }
</script>

<style>

</style>
