<template>
    <div><h1>Add Event</h1></div>
    <br>
    <br>
    <a-form :model="formState" :label-col="labelCol" :wrapper-col="wrapperCol" style="width: 600px; margin: auto;">
    <a-form-item label="Title">
      <a-input v-model:value="formState.title" />
    </a-form-item>
    <a-form-item label="Description">
      <a-textarea v-model:value="formState.description" />
    </a-form-item>
    <a-form-item label="Start Date">
      <a-date-picker
        v-model:value="formState.startDate"
        show-time
        type="date"
        placeholder="Pick a date"
        style="width: 100%"
      />
    </a-form-item>
    <a-form-item label="End Date">
      <a-date-picker
        v-model:value="formState.endDate"
        show-time
        type="date"
        placeholder="Pick a date"
        style="width: 100%"
      />
    </a-form-item>
    <a-form-item label="Location">
      <a-input v-model:value="formState.location" />
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button type="primary" @click="onSubmit">Create</a-button>
      <a-button style="margin-left: 10px">Cancel</a-button>
    </a-form-item>
  </a-form>
  </template>

<script lang="ts" setup>
import { UnwrapRef, onMounted, reactive, ref, toRaw } from 'vue';
import { Dayjs } from 'dayjs';
import router from '@/router';
import axios from 'axios';
const value = ref<Dayjs>();

const event = ref(Event);

interface FormState {
  title: string;
  description: string;
  location: string;
  startDate: Date;
  endDate: Date;
}

const formState: UnwrapRef<FormState> = reactive({
    title: '',
    description: '',
    location: '',
    startDate: undefined,
    endDate: undefined,
    });
    const onSubmit = () => {
      console.log('submit!', toRaw(formState));
      createEvent(toRaw(formState));
    };

const createEvent = async (form: any) => {
  try {
    const response = await axios.post('http://localhost:8080/create-event', form);
    event.value = response.data;
    console.log(event.value)
    alert("New event is created! Redirecting to calendar...")
    router.push({ name: 'home' });
  } catch (error) {
    console.error('Error while creating event:', error);
  }
};


</script>

<style>
.create-form {
  margin-top: 36px;
  width: 615px;
  margin-left: auto;
  margin-right: auto;
}
</style>