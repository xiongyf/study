import Vue from 'vue'
import Vuex from 'vuex'
import mutations from './mutations'
import actions from './action'

Vue.use(Vuex);

const state = {
  count: 0,
  data:{}
}

export default new Vuex.Store({
  state,
  mutations,
  actions
});
