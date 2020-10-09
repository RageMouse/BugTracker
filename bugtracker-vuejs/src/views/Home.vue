<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-img
          src="../assets/existenceispain.png"
          class="my-3"
          contain
          height="325"
        />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">Welcome to this place.</h1>

        <v-banner class="subheading font-weight-regular">
          This website was created for me test different things out. I also
          wanted to try to do things in a different way, a more optimized way.
        </v-banner>
      </v-col>
    </v-row>
      <v-footer 
      padless
      >
    <v-col
      class="text-center"
      cols="12"
    >
      <strong>They Don't Think It Be Like It Is But It Do </strong> — Oscar Gamble
    </v-col>
  </v-footer>
  </v-container>
</template>

<script>
export default {
  name: "Home",
  components: {},
};
</script>
