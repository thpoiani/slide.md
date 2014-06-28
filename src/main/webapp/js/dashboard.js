window.fbAsyncInit = function() {
  FB.init({
    appId      : '298779826965882',
    xfbml      : true,
    version    : 'v2.0'
  });
};

(function(w, d){
  'use strict';

  var share = d.querySelector('.share a');

  share.addEventListener('click', function(e){
    e.preventDefault();

    FB.ui({
      method: 'share',
      href: location.href,
    }, function(response){});
  });

}(window, document));

(function(d, s, id){
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) {return;}
   js = d.createElement(s); js.id = id;
   js.src = "//connect.facebook.net/en_US/sdk.js";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));