import Vue from 'vue';
import axios from 'axios';

Vue.prototype.$axios = axios;

export default async ({
  Vue,
  router
}) => {
  // Add a request interceptor
  axios.interceptors.request.use(function (config) {
    // Do something before request is sent
    console.log("interception request okkkkk");

    config.withCredentials = true;
 //   config.headers.common['Authorization'] = 'Bearer ' + localStorage.getItem('token');
    return config;
  }, function (error) {
    // Do something with request error
    console.log("interceptor request error");

    return Promise.reject(error);
  });

  // Add a response interceptor
  axios.interceptors.response.use(function (response) {
    // Any status code that lie within the range of 2xx cause this function to trigger
    // Do something with response data
    console.log("interceptor response okkkkkk");

    return response;
  }, function (error) {
    // Any status codes that falls outside the range of 2xx cause this function to trigger
    // Do something with response error
    console.log("interceptor response error");

   // router.push("/private")


    return Promise.reject(error);
  });
}
