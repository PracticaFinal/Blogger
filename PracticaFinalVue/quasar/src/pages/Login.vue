<template>
  <q-page class="flex flex-center">
    <img
      alt="Quasar logo"
      src="~assets/quasar-logo-full.svg"
    >
    <div class="q-pa-md" style="max-width: 400px">

      <q-form
        @submit="onSubmit"
        class="q-gutter-md"
      >
        <q-input filled v-model="text" label="Email" />
        <q-input v-model="password" filled :type="isPwd ? 'password' : 'text'" hint="Password">
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>


        <div>
          <q-btn label="Submit" type="submit" color="primary"/>
        </div>
      </q-form>

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
        password: '',
        text: '',
      }
    },
    methods: {
      onSubmit () {
        if (this.accept !== true) {
          console.log(this.password)
          send(this.text,this.password)
        }
        else {
          this.$q.notify({
            color: 'green-4',
            textColor: 'white',
            icon: 'cloud_done',
            message: 'Submitted'
          })
        }
      },
    }
  };
  async function send(text,password) {
    console.log(text)
    const login = await axios.post("http://localhost:8080/login",{
      method: 'POST',
      headers: {
        'Content-Type':'application/json'
      },
      body: {
        user: text,
        pass: password
      }
    });


    if(login.status === 401){
      console.log("no autorizado");

    } else{
      localStorage.setItem("id", login.data);
      console.log("logeacion");
      console.log(login.status)
    }
  }
</script>
