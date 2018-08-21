import Vue from 'vue'

export const rootUrl = './api'

export const addMsg = (msg) => Vue.http.post(rootUrl + "/user/add/" + msg);

export const getCurrUser = () => Vue.http.get(rootUrl + '/user/me');
