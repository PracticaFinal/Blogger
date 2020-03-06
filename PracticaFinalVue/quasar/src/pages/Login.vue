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
          <q-btn label="Submit" type="submit" @click="send"color="primary"/>
        </div>
      </q-form>

    </div>
  </q-page>
</template>

<script>
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
          send()
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
      async send() {
        const login = await this.$axios.post("http://localhost:8080/login?user="+this.text+"&password="+this.password,{
          method: 'POST',
          credentials: "include",
          headers: {
            'Content-Type':'application/json'
          },
          body: JSON.stringify({
            user:this.text,
            pass:this.password
          })

        });


        if(login.status == 401){
          console.log("no autorizado");

        } else{
          const log = await login.text();
          asd = log;
          console.log(log);
          console.log("logeacion");
          hola();
        }
      },
    }
  };
  var asd;

  async function hola() {
    const buscarFetch = await fetch("http://localhost:8080/listar",{
      credentials: "include",
      headers: {
        'Authorization': 'Bearer '+ asd,//que deberia estar guardado en el local storage con la funcion de abajo pero no lo hice
        'Content-Type':'application/x-www-form-urlencoded'
      }

    });
    const busca = await buscarFetch.json();
    console.log(busca);
    console.log("hola");
  }
</script>
