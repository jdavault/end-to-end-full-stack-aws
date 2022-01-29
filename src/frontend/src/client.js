import fetch from 'unfetch';

const getValidatedResponse = response => {
  if (response.ok) {
    return response;
  }
  // convert non-2xx HTTP responses into errors:
  const error = new Error(response.statusText);
  error.response = response;
  return Promise.reject(error);
}

export const getAllStudents = () =>
  fetch("api/v1/students", {
    method: 'GET'
  }).then(getValidatedResponse);

export const addNewStudent = student =>
  fetch("api/v1/students", {
    headers: {
      'Content-Type': 'application/json'
    },
    method: 'POST',
    body: JSON.stringify(student)
  }
  ).then(getValidatedResponse);

export const deleteStudent = studentId =>
  fetch(`api/v1/students/${studentId}`, {
    method: 'DELETE'
  }).then(getValidatedResponse);
