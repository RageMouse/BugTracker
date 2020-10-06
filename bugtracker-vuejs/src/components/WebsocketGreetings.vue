<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-img :src="require('../assets/logo.svg')" class="my-3" contain height="200" />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">Welcome to Websocket Test</h1>
        <h2>Websocket connection: {{ text }}</h2>
        <v-btn class="mr-2" color="success" :disabled="connected == true" @click.prevent="connect">Connect</v-btn>
        <v-btn color="error" :disabled="connected == false" @click.prevent="disconnect">Disconnect</v-btn>
      </v-col>

      <v-col class="mb-5" cols="12">
        <v-text-field :disabled="isDisabled" v-model="send_greeting" label="What is your name?"></v-text-field>
        <v-btn color="success" @click="isDisabled = !isDisabled" :disabled="connected == false" @click.prevent="send">Enter</v-btn>
        <v-text-field :maxlength="max" v-model="send_message" label="Type here to chat"></v-text-field>
        <v-btn color="success" :disabled="connected == false" @click.prevent="sendMessage">Send</v-btn>
      </v-col>
      <div class="row">
        <div class="col-md-12">
          <table id="conversation" class="table table-striped">
            <thead>
              <tr>
                <th>Greetings</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in received_messages" :key="item">
                <td>{{ item }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </v-row>
  </v-container>
</template>

<script>
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";

export default {
  name: "websocketdemo",
  data() {
    return {
      received_messages: [],
      send_greeting: null,
      send_message: null,
      connected: false,
      text: "",
      isDisabled: false,
      max: 256
    };
  },
  methods: {
    send() {
      console.log("Send greeting:" + this.send_greeting);
      if (this.stompClient && this.stompClient.connected) {
        const msg = { name: this.send_greeting };
        console.log(JSON.stringify(msg));
        this.stompClient.send("/app/hello", JSON.stringify(msg), {});
      }
    },
    sendMessage() {
      console.log("Send message:" + this.send_message);
      if (this.send_message == ""){
        console.log("Send message:" + this.send_message);
      }
      else if (this.stompClient && this.stompClient.connected) {
        const msg = { 
          name: this.send_greeting, 
          message: this.send_message };
        console.log(JSON.stringify(msg));
        this.stompClient.send("/app/chat", JSON.stringify(msg), {});
        this.send_message = "";
      }
    },
    connect() {
      this.socket = new SockJS("http://localhost:8008/websocket");
      this.stompClient = Stomp.over(this.socket);
      this.stompClient.connect(
        {},
        frame => {
          this.connected = true;
          console.log(frame);
          this.stompClient.subscribe("/topic/greetings", tick => {
            console.log(tick);
            this.received_messages.push(JSON.parse(tick.body).content);
          });
          this.text + "You are part of the Great Scheme."
        },
        error => {
          console.log(error);
          this.connected = false;
          this.text = "No Connection possible."
        }
      );
    },
    disconnect() {
      if (this.stompClient) {
        this.stompClient.disconnect();
      }
      this.connected = false;
    },
    tickleConnection() {
      this.connected ? this.disconnect() : this.connect();
    }
  },
  mounted() {
    // this.connect();
  }
};
</script>

