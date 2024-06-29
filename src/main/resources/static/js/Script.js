document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');

    signUpButton.addEventListener('click', function(event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const forgotPasswordButton = document.querySelector('.forgot a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');
    const forgotPasswordContainer = document.querySelector('.form-container.forgot-password');

    signUpButton.addEventListener('click', function(event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    forgotPasswordButton.addEventListener('click', function(event) {
        event.preventDefault();
        forgotPasswordContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });

    // Handle "Remember your password?" link in the Forgot Password form
    const loginLinkInForgot = document.querySelector('.forgot-password .login-link');
    loginLinkInForgot.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        forgotPasswordContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });
});
