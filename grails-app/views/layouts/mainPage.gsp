<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>POI</title>

    <!-- Bootstrap CSS -->
    <asset:stylesheet src="bootstrap.css"/>
    <!-- bootstrap theme -->
    <asset:stylesheet src="bootstrap-theme.css"/>
    <!--external css-->
    <!-- font icon -->
    <asset:stylesheet src="elegant-icons-style.css"/>
    <asset:stylesheet src="font-awesome.css"/>
    <asset:stylesheet src="application.css"/>
    <!-- Custom styles -->
    <asset:stylesheet src="style.css"/>
    <asset:stylesheet src="style-responsive.css"/>

      <asset:javascript src="html5shiv.js"/>
      <asset:javascript src="respond.min.js"/>
      <asset:javascript src="lte-ie7.js"/>
    <g:layoutHead/>
</head>

<body>
<!-- container section start -->
<section id="container" class="">
    <!--header start-->

    <header class="header dark-bg">
        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>

        <!--logo start-->
        <a href="/" class="logo">Plateform <span class="lite">POI</span></a>
        <!--logo end-->

        <div class="nav search-row" id="top_menu">
            <!--  search form start -->
            <ul class="nav top-menu">
                <li>
                    <form class="navbar-form">
                        <input class="form-control" placeholder="Search" type="text">
                    </form>
                </li>
            </ul>
            <!--  search form end -->
        </div>

        <div class="top-nav notification-row">
            <!-- notificatoin dropdown start-->
            <ul class="nav pull-right top-menu">



                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="profile-ava">

                            <asset:link rel="icon" href="avatar1_small.jpg" />
                        </span>
                        <span class="username">${projetpoiss.User.findById(sec.loggedInUserInfo(field: 'id')).prenom}   ${projetpoiss.User.findById(sec.loggedInUserInfo(field: 'id')).nom}   </span>


                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top">

                            <g:link class="edit" action="show" controller="user" id="${sec.loggedInUserInfo(field: 'id')}">Mon Profil</g:link>
                            <g:link class="edit" action="edit" controller="user" id="${sec.loggedInUserInfo(field: 'id')}">Modifier Profil</g:link>
                            <g:link class="edit" controller="logout">Déconnexion</g:link>

                        </li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!-- notificatoin dropdown end-->
        </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li class="">
                    <a class="" href="/poi/index">

                        <span>Poi</span>
                    </a>
                </li>
            <li class="">
                <a class="" href="/groupe/index">

                    <span>Groupe</span>
                </a>
            </li>

                <li>
                    <a class="" href="/image/index">

                        <span>Image</span>
                    </a>
                </li>
                <li>
                    <a class="" href="/user/index">

                        <span>Utilisateur</span>

                    </a>

                </li>

            <li>
                <a class="" href="/role/index">

                    <span>Rôle</span>

                </a>

            </li>




        </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->

     <!--main content start-->
    <section id="main-content">
        <section class="wrapper">

            <g:layoutBody/>
        </section>
    </section>

    <!--main content end-->

</section>
<!-- container section end -->
<!-- javascripts -->
<asset:javascript src="jquery.js"/>
<asset:javascript src="bootstrap.min.js" />
<!-- nice scroll -->
<asset:javascript src="jquery.scrollTo.min.js"/>
<asset:javascript src="jquery.nicescroll.js"/>
<!--custome script for all page-->
<asset:javascript src="scripts.js"/>


</body>

</html>
