<template>
  <v-container>
    <v-card class="elevation-12">
      <v-toolbar dark color="primary">
        <v-toolbar-title>Create Project</v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-form ref="form" v-model="valid" lazy-validation>
          <v-text-field
            id="projectName"
            v-model="projectName"
            :counter="25"
            :rules="[(v) => !!v || 'Name is required']"
            label="Name"
            required
          ></v-text-field>

          <v-textarea
            id="projectDescription"
            v-model="projectDescription"
            :counter="255"
            :rules="[(v) => !!v || 'Description is required']"
            label="Description"
            required
          ></v-textarea>

          <v-text-field
            id="projectLink"
            v-model="projectLink"
            label="Project URL"
          ></v-text-field>

          <v-btn
            id="validateButton"
            :disabled="!valid"
            color="success"
            class="mr-4"
            @click="validate"
            >Validate</v-btn
          >
        </v-form>
      </v-card-text>
    </v-card>

    <v-snackbar v-model="snackbar">
      Success!
      <v-btn color="pink" text @click="snackbar = false">Close</v-btn>
    </v-snackbar>
  </v-container>
</template>

<script>
export default {
  methods: {},
};
</script>