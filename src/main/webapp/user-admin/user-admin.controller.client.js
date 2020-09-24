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

const init = () => {
  //jQuery('h1').css('backgroundColor', 'blue')
  //let $ul = $('<ul>')
  //for(let i = 0; i < users.length; i++) {
  $('.wbdv-create').click(() => {
    console.log($('#usernameFld').val())
    $('#usernameFld').val('')
  })
  $.get('https://wbdv-generic-server.herokuapp.com/api/jannunzi/users',
     renderUsers)
}

function renderUsers(users) {
  //var $newRow = $userRowTemplate.clone(withDataAndEvents=true);
  $('tr.wbdv-added').remove();
  for (let u of users) {
    //$ul.append($('<li>' + u.username + '</li>'));
    let $newRow = $('.wbdv-template').clone()
    //let $newRow = $userRowTemplate.clone()
    $newRow.removeClass('wbdv-template').removeClass('wbdv-hidden').addClass('wbdv-added')
    $newRow.attr('wbdv-username', u._id)
    $newRow.find('.wbdv-username').html(u.username)
    $newRow.find('.wbdv-first-name').html(u.first)
    $('tbody').append($newRow)
  }
  //$('div.container').append($ul)
  $('.wbdv-remove').click((evt) => deleteUser2(evt, users))
}

function deleteUser2(evt, users) {
  // determine which user was clicked
  const uname = $(evt.currentTarget).parents('tr.wbdv-user').attr('wbdv-username')
  // remove that user from array
  users = users.filter(u => u.username !== uname);
  renderUsers(users)
}

function deleteUser(evt) {
  //console.log(evt)
  $(evt.currentTarget).parents('tr.wbdv-user').remove()
  //console.log('delete clicked')
}

$(init)