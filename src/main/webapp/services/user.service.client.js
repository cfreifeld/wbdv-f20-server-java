class AdminUserServiceClient {
  constructor() {
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/ccf/users';
  }
  //createUser(user) { … }
  findAllUsers(cb) {
    fetch(this.url).then(response => response.json())
        .then(users => cb(users))
    //$.get(this.url, cb)
  }
  // findUserById(userId) { … }
  // updateUser(userId, user) { … }
  // deleteUser(userId) { … }
}
