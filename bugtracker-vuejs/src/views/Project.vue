<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12"></v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">
          Here is the currently selected project.
        </h1>

        <v-banner class="subheading font-weight-regular">
          Where bugs go to get squashed.
        </v-banner>
        <v-col  >
        </v-col>
        <Project/>
        <BugList/>
      </v-col>
    </v-row>
    <v-row> </v-row>
  </v-container>
</template>

<script>
import Project from '@/components/Project.vue'
import BugList from '../components/BugList.vue'

export default {
  name: "ProjectDetails",
  components: {
    Project,
    BugList
  }
};
</script>
