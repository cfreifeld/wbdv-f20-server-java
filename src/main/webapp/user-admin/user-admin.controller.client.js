let users = [
  {
    username: 'ironman',
    firstname: 'Tony',
    lastname: 'Stark',
    role: 'FACULTY'
  },
  {
    username: 'tchalla',
    firstname: "T'Challa",
    lastname: '',
    role: "FACULTY"
  },
  {
    username: 'captmarvel',
    firstname: 'Carol',
    lastname: 'Danvers',
    role: 'ADMIN'
  }
]
let $template
const init = () => {
  //jQuery('h1').css('backgroundColor', 'blue')
  //let $ul = $('<ul>')
  //for(let i = 0; i < users.length; i++) {
  $template = $('.wbdv-template').clone()
  $('.wbdv-create').click(() => {
    console.log($('#usernameFld').val())
    $('#usernameFld').val('')
  })
  // TODO: Use the findAllUsers function instead
  $.get('https://wbdv-generic-server.herokuapp.com/api/ccf/users',
     renderUsers)
}
function renderUsers(users) {
  //var $newRow = $userRowTemplate.clone(withDataAndEvents=true);
  //$('tr.wbdv-added').remove();
  let $tbody = $('tbody')        // as suggested by IntelliJ: find tbody once and store it
  $tbody.empty()
  for (let u of users) {
    //$ul.append($('<li>' + u.username + '</li>'));
    let $newRow = $template.clone()
    //let $newRow = $userRowTemplate.clone()
    $newRow.removeClass('wbdv-template').removeClass('wbdv-hidden')//.addClass('wbdv-added')
    $newRow.attr('wbdv-userid', u._id)
    $newRow.find('.wbdv-username').html(u.username)
    $newRow.find('.wbdv-first-name').html(u.first)
    $tbody.append($newRow)
  }
  //$('div.container').append($ul)
  $('.wbdv-remove').click((evt) => deleteUser2(evt, users))
}

function deleteUser2(evt, users) {
  // determine which user was clicked
  const id = $(evt.currentTarget).parents('tr.wbdv-user').attr('wbdv-userid')
  // remove that user from array
  users = users.filter(u => u._id !== id);
  // TODO: instead of removing user from the local array, make DELETE request to
  // the server, and then findAllUsers to get the updated list of users.
  renderUsers(users)
}

function deleteUser(evt) {
  //console.log(evt)
  $(evt.currentTarget).parents('tr.wbdv-user').remove()
  //console.log('delete clicked')
}

$(init)