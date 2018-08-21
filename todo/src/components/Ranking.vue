<template>
  <div>
    <rank-list :list="list" @onSelected="onListSelected"></rank-list>
  </div>
</template>

<script>
  import RankList from './RankList'

  export default {
    components: {RankList},
    data() {
      return {
        list: [
          {
            name: 'Apple',
            value: '20',
            percentage: '20%'
          },
          {
            name: 'Grape',
            value: '50',
            percentage: '50%'
          },
          {
            name: 'Mango',
            value: '30',
            percentage: '30%'
          }
        ]
      }
    },
    methods: {
      onListSelected(item, index) {
        alert(item.name + ' ' + index)
      }
    }
  }

</script>
