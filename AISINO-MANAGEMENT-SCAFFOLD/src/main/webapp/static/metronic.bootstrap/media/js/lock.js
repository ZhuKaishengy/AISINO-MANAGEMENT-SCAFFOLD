var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {
             $.backstretch([
		        "../static/pic/bg/1.jpg",
		        "../static/pic/bg/2.jpg",
		        "../static/pic/bg/3.jpg",
		        "../static/pic/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 3000
		      });
        }

    };

}();