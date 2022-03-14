# GSB
GSB AppliFrais Android Application with API <br>
<a href="https://www.figma.com/file/j14wK5qanIzgDU89yGrELE/Untitled?node-id=0%3A1">Maquette FIGMA</a>

<h2>Le projet</h2>
Le laboratoire Galaxy Swiss Bourdin (GSB) est amené dans ses différentes activités à contacter les
médecins installés. Par exemple les visiteurs médicaux du laboratoire se déplacent afin de présenter
les nouveaux produits pharmaceutiques.
Une base de données de médecins est utilisée dans ces différents processus. Cette base de données
évolue fréquemment du fait de la cessation d’activité (retraite ou autre) de certains médecins ou
l’installation de nouveaux praticiens.
Il a été décidé de confier à une société de services informatiques la responsabilité de développer un
service web donnant accès aux informations de la base de données.

  <h3>Des contraintes ont été fixées :</h3>

<ul>
<li>L’accès sera privé ;</li>
<li>Le format généré (XML ou JSON) devra pouvoir être récupéré dans des applications
diverses ;</li>
  </ul>
La société de services a fait le choix des technologies suivantes :

  <ul>
    <li>Une base de données sous MySQL ;</li>
<li>Le langage PHP et le framework CodeIgniter pour développer le service web ;</li>
<li>Un service REST ;</li>
<li>Des formats de sortie multiples : XML, JSON, HTML, CSV et ceci à la demande des clients</li>
interrogeant le service web ;</li>
  </ul>
Par ailleurs, il a été décidé de procéder en deux temps dans le déploiement :

<ul>
  <li>Phase 1, mise en ligne d’une partie de la base de données, réduite à quelques départements</li>
  <li>Phase 2, généralisation après expérimentation.</li>
  </ul>


<h3>Choix de sécurité</h3>
Actuellement, le service web dans sa phase 1 n’est pas sécurisé par une authentification
(username/password). Plus tard, dans la phase 2, l’authentification sera nécessaire et pourra être
véhiculée de deux manières :

<ul>
<li>Dans la queryString (derrière l’URL). Cette option permettra d’atteindre l’information
  simplement. Elle sera supprimée en phase de production.</li>
<li> Dans l’en-tête http. C’est cette solution qu’il faudra privilégier dans une application
  consommant le service.</li>
</ul>
<h2>Objectif de la mission</h2>
Afin d’évaluer concrètement la phase 1, l’objectif courant consiste à la mettre en exploitation. Pour
cela, il est nécessaire de concevoir et développer les interfaces qui permettront l’usage du service web
au moyen d’équipements mobiles de type Android.
  
  <h2>Format de sortie des données</h2>
Le format par défaut est XML. Le service web propose également les formats JSON, CSV, HTML
(table) que l’on peut demander en modifiant :

<ul>
  <li>Soit, l’en-tête HTTP ainsi :</li>
    <ul>
      <li>Accept: application/json pour JSON</li>
      <li>Accept: application/csv pour CSV</li>
      <li>Accept: text/html pour HTML</li>
    </ul>
 </ul>
<ul>
  <li>Soit, la queryString dans l’url :</li>
    <ul>
      <li>url_du_service_web/format/json o url_du_service_web /format/csv</li>
      <li>url_du_service_web /format/html </li>
  </ul>
 </ul>
