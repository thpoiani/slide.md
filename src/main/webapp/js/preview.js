window.fbAsyncInit = function() {
  FB.init({
    appId      : '298779826965882',
    xfbml      : true,
    version    : 'v2.0'
  });
};

(function(w, d, remark){
  'use strict';

  remark.create();

  // FB.ui({
  //   method: 'share',
  //   href: location.href,
  // }, function(response){});

}(window, document, window.remark));

(function(d, s, id){
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) {return;}
   js = d.createElement(s); js.id = id;
   js.src = "//connect.facebook.net/en_US/sdk.js";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));