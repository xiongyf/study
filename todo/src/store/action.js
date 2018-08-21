export default {
  doIncrease({commit}) {
    commit('increment');
  }
  ,
  doSetData({commit,dispatch},info){
    commit('setData',info);
  }
}
