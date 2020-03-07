<template>
  <q-page class="flex flex-center">
    <img alt="Quasar logo" src="~assets/quasar-logo-full.svg" />
    <div class="q-pa-md" style="max-width: 400px">
      <q-form @submit="onSubmit" class="q-gutter-md">
        <q-input filled v-model="text" label="Email" />
        <q-input
          v-model="password"
          filled
          :type="isPwd ? 'password' : 'text'"
          hint="Password"
        >
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>

        <div>
          <q-btn label="Submit" type="submit" color="primary" />
        </div>
      </q-form>
    </div>
  </q-page>
</template>

<script>
import axios from "axios";
export default {
  name: "PageIndex",
  data() {
    return {
      isPwd: true,
      password: "",
      text: ""
    };
  },
  methods: {
    onSubmit() {
      if (this.accept !== true) {
        console.log(this.text);
        console.log(this.password);
        send(this.text, this.password);
      } else {
        this.$q.notify({
          color: "green-4",
          textColor: "white",
          icon: "cloud_done",
          message: "Submitted"
        });
      }
    }
  }
};
async function send(usr, pass) {
  console.log(usr);
  console.log(pass);

  const login = await axios.get("http://localhost:3000/api/users/token/getpepe", {
      credentials: "include",
      headers: {
        "Content-Type": "application/json"
      }
    }
  );
  aJava(login.data.jwt);
  console.log(login.data.jwt);
  console.log("logeacion");
}

async function aJava(token) {
  const buscarFetch = await axios.get("http://localhost:8080/listar", {
    credentials: "include",
    headers: {
      Authorization: "Bearer " + token,
      "Content-Type": "application/x-www-form-urlencoded"
    }
  });
  console.log(buscarFetch.data);
  console.log("aJava");
}
</script>
