<template>
  <div>
    <ul>
      <li v-for="(item,index) in list" :key="index" :style="{fontSize:postFontSize + 'em' }"
          @click="onSelected(item,index)">
        <span>{{item.name}}</span>
        <span>{{item.value}}</span>
        <span>{{item.percentage}}</span>
      </li>
    </ul>

  </div>
</template>

<script>
  export default {
    name: 'RankList',
    data() {
      return {}
    },
    props: {
      list: Array,
      postFontSize: {
        type: Number,
        default: 1
      }
    },
    methods: {
      onSelected(item, index) {
        this.$emit('onSelected', item, index);
      }
    }
  }

</script>

