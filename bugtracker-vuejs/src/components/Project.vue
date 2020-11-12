<template>
  <v-card class="mx-auto text-left" max-width="1250">
    <v-img
      class="white--text align-end mt-4"
      height="500px"
      src="https://picsum.photos/800"
    >
      <v-card-title>{{ project.projectName }}</v-card-title>
    </v-img>
    <v-card-subtitle>
      {{ project.projectId }}
    </v-card-subtitle>
    <v-card-text class="text--primary">
      <div>
        {{ project.projectDescription }}
      </div>
    </v-card-text>

    <v-card-actions>
      <v-spacer></v-spacer>

      <v-btn depressed color="primary" to="/projects">Back</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "projectDetails",
  computed: {
    project() {
      return this.$store.getters.project;
    },
  },
  mounted() {
    this.getProject();
  },
  methods: {
    getProject() {
      return this.$store.dispatch("getProject", this.$route.params.id);
    },
  },
};
</script>