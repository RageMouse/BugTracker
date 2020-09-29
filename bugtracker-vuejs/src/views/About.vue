<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-img src="../assets/dance.gif" class="my-3" contain height="300" />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">About Page</h1>

        <p class="subheading font-weight-regular">
          Go here for the Soure Code,
          <br />please have a look and give feedback
          <a
            href="https://github.com/RageMouse/BugTracker"
            target="_blank"
          >GitHub Repository</a>
        </p>
      </v-col>

      <v-col class="mb-5" cols="12">
        <h2 class="headline font-weight-bold mb-3">What's next?</h2>
      </v-col>

      <v-col class="mb-5" cols="12">
        <h2 class="headline font-weight-bold mb-3">Important Links</h2>
      </v-col>

      <v-col class="mb-5" cols="12">
        <h2 class="headline font-weight-bold mb-3">Ecosystem</h2>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "About",
  
};
</script>
