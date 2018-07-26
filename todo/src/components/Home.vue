<template>
  <div>
    <div>
      <button @click="pushRouter('/home')">Home</button>
      <button @click="pushRouter('/home/todolist')">Todo list</button>
      <button @click="pushRouter('/home/ranking')">Ranking list</button>
    </div>
    <router-view class="router-view"></router-view>
  </div>
</template>

<script>
  export default {
    data() {
      return {}
    },
    methods: {
      pushRouter(url) {
        this.$router.push({path: url})
      }
    }
  }

</script>
