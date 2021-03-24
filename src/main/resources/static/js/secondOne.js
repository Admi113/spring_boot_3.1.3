document.getElementById('secondTab').setAttribute("tab","tab")
    console.log(document.readyState)
    console.log(document.querySelector('.tBtn'))


    const table = document.querySelector('.maintable .btn-primary');
    document.addEventListener('readystatechange', () => {
        console.log(document.readyState)
        console.log(window.onload)
        console.log(table)
        if (document.readyState == 'complete'){

            console.log(document.querySelector(' .edit_modal_form1'))
        }
    });
    // window.addEventListener("load", ()=> {
    //     console.log(document.querySelector('.edit_modal_form'));
    //     // document.querySelector(' .modal-open').addEventListener('click', (e) => {
    //     //     e.preventDefault();
    //     //     console.log("wtf is going on?");
    //     // })
    // });
    //
    // console.log(document.querySelector('.edit_modal_form'))
    // if (document.readyState == 'complete') {
    //     console.log(document.readyState)
    //     console.log(document.querySelector('.edit_modal_form'))
    // }
    //  $( window ).on( "load", function() {
    //      document.querySelector(' .edit_modal_form').addEventListener('click', (e) => {
    //          e.preventDefault();
    //          console.log("wtf is going on?")
    //      })
    //  });
    //  window.onload =()=>{
    //      console.log(document.querySelector(' .edit_modal_form'))
    //
    //  }
    //
    // $( document ).ready(function (){
    //     console.log(document.querySelector(' .edit_modal_form'))
    // })
    //
    //


    // addUserForm.addEventListener("submit", (e) => {
    //     e.preventDefault();
    //     let role = document.getElementById("select_role");
    //     const roles = [];
    //     for (let i = 0; i < role.length; i++) {
    //         if (role[i].selected) {
    //             let data = {
    //                 id: Number(role[i].value),
    //                 role: role[i].text
    //             }
    //             roles.push(data)
    //         }
    //     }
    //     // console.log(roles);
    //
    //     fetch("http://localhost:8081/admin/save", {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json"
    //         },
    //         body: JSON.stringify({
    //             name: document.getElementById("username_create").value,
    //             surname: document.getElementById("lastname_create").value,
    //             password: document.getElementById("password_create").value,
    //             email: document.getElementById("inputEmail4_create").value,
    //             age: document.getElementById("age_create").value,
    //             roles: roles
    //         })
    //     })
    //         .then(response => {
    //             response.json()
    //                 .then(data => {
    //                     // printUsers(data)
    //                     printTable()
    //                 })
    //         });
    //
    // })