<template>
  <q-page class="flex flex-center">
    <q-btn color="deep-orange" push @click="$router.replace('/form')">
      <div class="row items-center no-wrap">
        <div class="text-center">
          Add new<br>POST
        </div>
      </div>
    </q-btn>
    <div class="q-pa-md" >
      <li v-for="(posts) in this.posts" >
        Title: {{posts.label.title}}
        Content: {{posts.label.content}}
        Traducted Title: {{posts.label.traductedTitle}}
        Traducted Content: {{posts.label.traductedContent}}
        Date of Post: {{posts.label.datePost}}
        Posted by: {{posts.label.user.name}}
        <q-btn color="white" text-color="black" label="Delete" push @click="deletee(posts.label.id)" />
        <q-btn color="white" text-color="black" label="Update" @click=""/>
      </li>
    </div>
  </q-page>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'PageIndex',
    data () {
      return {
        isPwd: true,
        posts: [],
      }
    },
    created: async function(){
      this.posts = await this.send(this.posts);
      console.log(this.posts)
    },

    methods: {
      deletee: async function(id){
        await axios.get("http://localhost:8080/delete?idpost="+parseInt(id),{
          method: 'GET',
          headers: {
            'Content-Type':'application/json'
          }
        }).then(function() {
          window.location.reload();
        });
      },
      show: function () {
        console.log(this.posts)
      },
      send:async function(posts) {
        const postsjson = await axios.get("http://localhost:8080/buscar",{
          method: 'GET',
          headers: {
            'Content-Type':'application/json'
          }
        });
        let arrayposts = [];
        postsjson.data.map(function(post){
          console.log(post)
          arrayposts.push({
            label: post,
          });
        });
        posts = arrayposts;
        console.log(posts)
        return posts
      },

    }
  };

</script>
