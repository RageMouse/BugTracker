<template>
  <v-card class="mx-auto" max-width="1500">
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
              :src="'https://favorflav.com/images/shutterstock_758273548-916x458.jpg'"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="200px"
            >
              <v-card-title v-text="project.projectName"></v-card-title>
            </v-img>

            <v-card-actions>
              <!-- <router-link :to="{path: '/showAuction/' + card.auctionId}" tag="v-btn">
                <v-btn text>Details</v-btn>
              </router-link> -->

              <v-spacer></v-spacer>

              <v-btn icon>
                <v-icon>mdi-heart</v-icon>
              </v-btn>

              <v-btn icon>
                <v-icon>mdi-bookmark</v-icon>
              </v-btn>

              <v-btn icon>
                <v-icon>mdi-share-variant</v-icon>
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