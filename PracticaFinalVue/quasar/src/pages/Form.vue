<template>
  <div class="q-pa-md" style="max-width: 400px">

    <q-form
      @submit="insertPost"
      @reset="onReset"
      class="q-gutter-md"
    >
      <q-input
        filled
        v-model="title"
        label="The title *"
        hint="the title of your post"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />
      <q-input
        filled
        v-model="content"
        label="The content *"
        hint="the content of your post"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please writte something on your content']"
      />
      <q-select filled v-model="len"  :options="namelenguages" label="Original lenguage" />
      <q-select filled v-model="tralen" :options="namelenguages" label="Traducted lenguage" />
      <q-input filled v-model="tratitle" label="Traducted title" />
      <q-input filled v-model="tracontent" label="Traducted Content" />


      <div>
        <q-btn label="Submit" type="submit" color="primary"/>
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>

  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    data () {
      return {
        ori: null,
        tra: null,
        title: null,
        content: null,
        len: null,
        tralen: null,
        tratitle: null,
        tracontent: null,
        lenguages: [],
        namelenguages:[],
      }
    },
    created: async function(){
      this.lenguages = await this.alllenguages(this.posts);
      if(this.$router.currentRoute.query.postId){
        const postsjson = await axios.get("http://localhost:8080/buscar",{
          method: 'GET',
          headers: {
            'Content-Type':'application/json'
          }
        });

        for (let i = 0; i <postsjson.data.length ; i++) {
          if (postsjson.data[i].id===this.$router.currentRoute.query.postId){
            this.title = postsjson.data[i].title;
            this.content = postsjson.data[i].content;
            this.tratitle = postsjson.data[i].traductedTitle;
            this.tracontent = postsjson.data[i].traductedContent;
            for (let j = 0; j <this.lenguages.length ; j++) {
              if (this.lenguages[j].code === postsjson.data[i].lenguage){
                this.len=this.lenguages[j].name
              }
              if (this.lenguages[j].code === postsjson.data[i].traductedLenguage){
                this.tralen=this.lenguages[j].name
              }
            }
          }
        }

      }
      for (let i = 0; i <this.lenguages.length ; i++) {
        this.namelenguages.push(this.lenguages[i].name)
      }
    },
    methods: {
      onReset () {
        this.name = null
        this.age = null
      },
      alllenguages: async function(){
        let obj = {
          MethodName: 'languages',
          params: ''
        };
        const traducted = await axios({
          method: 'POST',
          url: "http://server247.cfgs.esliceu.net/bloggeri18n/blogger.php",
          data: {
            MethodName: 'languages',
            params: ''
          },
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          }
        });
        /*const traducido =await axios.post("http://server247.cfgs.esliceu.net/bloggeri18n/blogger.php",{
          method: "POST",
          body:JSON.stringify(obj),
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
          }
        });*/
        return traducted.data;
      },
      insertPost: async function(){
        let idpost = this.$router.currentRoute.query.postId
        let metodo = "POST";
        let idiomaIni = '';
        let idiomaTra = '';
        for (let i = 0; i <this.lenguages.length ; i++) {
          if (this.lenguages[i].name === this.len){
            idiomaIni=this.lenguages[i].code
          }
          if (this.lenguages[i].name === this.tralen){
            idiomaTra=this.lenguages[i].code
          }
        }

        let obj = {
          id: idpost,
          titletra:this.tratitle,
          contenttra:this.tracontent,
          title:this.title,
          contentent: this.content,
          lenguage: idiomaIni,
          tralenguage: idiomaTra,
          iduser: localStorage.getItem("id"),
          date : new Date()
        };
        if (!idpost){
          await axios.post("http://localhost:8080/savePost",{
            method: metodo,
            headers: {
              'Content-Type': 'application/json',
            },
            body: obj
          });
        }
        else {
          await axios.post("http://localhost:8080/updateForm",{
            method: metodo,
            headers: {
              'Content-Type': 'application/json',
            },
            body: obj
          });
        }

      },
      getParameterByName: function(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    let regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
      results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
  }
    }
  }

</script>

<style scoped>

</style>
