document.addEventListener('htmx:load', function (event) {
    const wrapper = document.querySelector('.wrapper');
    const loginLink = document.querySelector('.loginLink');
    const registrierenLink = document.querySelector('.registrierenLink');
    const btnNavLogin = document.querySelector('.btnNavLogin');
    const boxSchließen = document.querySelector('.boxSchließen');

    if (registrierenLink && wrapper) {
        registrierenLink.addEventListener('click', () => {
            console.log('Link wurde geklickt');
            wrapper.classList.add('active');
        });
    }
    
    if (loginLink && wrapper) {
        loginLink.addEventListener('click', ()=> {
            wrapper.classList.remove('active');
        })
    }
    
    btnNavLogin.addEventListener('click', ()=> {
        wrapper.classList.add('active-popup');
    });

    boxSchließen.addEventListener('click', ()=> {
        wrapper.classList.remove('active-popup');
    });
    
});