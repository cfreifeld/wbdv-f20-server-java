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
  for (let u of users) {
    //$ul.append($('<li>' + u.username + '</li>'));

    let $newRow = $('.wbdv-template').clone()
    $newRow.removeClass('wbdv-template')
    $newRow.find('.wbdv-username').html(u.username)
    $newRow.find('.wbdv-first-name').html(u.firstname)
    $('tbody').append($newRow)
  }
  //$('div.container').append($ul)
}
$(init)