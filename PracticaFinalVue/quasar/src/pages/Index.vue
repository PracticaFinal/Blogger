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
        TITLE: {{posts.label.title}}
        CONTENT: {{posts.label.content}}
        TRADUCTED TITLE: {{posts.label.traductedTitle}}
        TRADUCTED CONTENT: {{posts.label.traductedContent}}
        DATE OF POST: {{posts.label.datePost}}
        POSTED BY: {{posts.label.user.name}}
        <q-btn color="white" text-color="black" label="Delete" push @click="deletee(posts.label.id)" />
        <q-btn color="white" text-color="black" label="Update" @click="$router.replace({path: '/form', query: { postId: posts.label.id } })"/>
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
      this.posts = await this.show(this.posts);
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
      update: function(id){
        ;
      },

      show:async function(posts) {
        const postsjson = await axios.get("http://localhost:8080/buscar",{
          method: 'GET',
          headers: {
            'Content-Type':'application/json'
          }
        });
        let arrayposts = [];
        postsjson.data.map(function(post){
          arrayposts.push({
            label: post,
          });
        });
        posts = arrayposts;
        return posts
      },

    }
  };

</script>
