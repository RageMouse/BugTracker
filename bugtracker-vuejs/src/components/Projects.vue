<template>
  <v-card class="elevation-12 mx-auto" max-width="1500">
    <v-container fluid>
      <v-row dense>
        <v-col
          v-for="project in projects"
          :key="project.projectId"
          cols="12"
          md="3"
          sm="4"
          xs="12"
        >
          <v-card>
            <v-img
              :src="'https://picsum.photos/400'"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="200px"
            >
              <v-card-title v-text="project.projectName"></v-card-title>
            </v-img>
            <v-card-text>
              <v-row align="center" class="mx-0" v-text="project.projectDescription"> </v-row>
            </v-card-text>

            <v-card-actions>
              <!-- <router-link :to="{path: '/showAuction/' + card.projectId}" tag="v-btn">
                <v-btn text>Details</v-btn>
              </router-link> -->

              <v-spacer></v-spacer>

              <v-btn icon>
                <v-icon>mdi-heart</v-icon>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
export default {
  name: "projectList",
  computed: {
    projects() {
      return this.$store.getters.projects;
    },
  },
  mounted() {
    this.getAllProjects();
  },
  methods: {
    getAllProjects() {
      return this.$store.dispatch("getAllProjects");
    },
  },
};
</script>