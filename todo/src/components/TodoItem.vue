<template>
  <div>
    <li
      class="item"
      @click="del(index)"
    >{{content}}</li>
  </div>
</template>

<script>
export default {
  props:['content','index'],
  methods:{
    del(){
      this.$emit('del',this.index);
    }
  }
}
</script>

<style>

</style>
