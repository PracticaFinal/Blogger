import Vue from 'vue';
import axios from 'axios';
// eslint-disable-next-line no-unused-vars
import router from 'vue-router';

Vue.prototype.$axios = axios;

// eslint-disable-next-line no-unused-vars,no-shadow
export default async ({ Vue, router }) => {
  axios.interceptors.request.use((config) => {
    config.withCredentials = true;
    config.headers.common['Authorization'] = 'Bearer'+ localStorage.getItem('token');
    // Do something before request is sent
    return config;
  }, (error) => {
    console.log('Entra interceptor request error')
    // Do something with request error
    return Promise.reject(error);
  });

  // Add a response interceptor
  axios.interceptors.response.use((response) => {
    console.log('Entra interceptor response')
    return response;
  }, (error) => {
    console.log('Entra interceptor response error');

    router.push("/private")

    return Promise.reject(error);
  });
};
