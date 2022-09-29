# sensixProject
Maven project generted with com.a9ski:quick-start archetype


# Development guide
1. Install pre-commit (https://pre-commit.com/)
2. Install the pr-commit hook by executing `pre-commit install` inside project directory
3. Run against all files in the project: `pre-commit run --all-files`

# Description

Proiectul este pregatit oarecum sa ruleze pe mai multe OS-uri. Driverele sunt sunt actualizate neaparat, iar setarile actuale sunt pentru Google Chrome - Windows.
In package-ul browser se pot gasi driverele pentru Google Chrome pentru Linux, MacOS si Windows.

De asemenea proiectul are pregatite o parte din setarile pentru Continuous Integration astfel ca interfata grafica nu este afisata la rulare.
Setarile se pot gasi in BaseTest.java. Iar acolo se poate gasi de asemenea o setare prin care daca este rulata interfata grafica si se ruleaza driver-ul browser-ului,
daca acesta nu este inchis corespunzator, in TaskManager raman active, iar prin aceasta setare - toate aceste procese sunt omorate. Aceasta setare nu poate rula
in acelasi timp cu ascunderea interfetei grafice.

Paginile de teste sunt corelate prin constructor pentru a putea folosi WebDriver-ul.
In BasePage am scris principalele actiuni insotite de un waiter. Am considerat util si am refolosit actiunile din acea pagina.

Au fost folosite si principiile POO.

Proiectul este structurat in trei parti:
- sensix
- form
- wikipedia

Paginile pentru Sensix sunt organizate intr-un package separat.

1. Sensix

Aici am creat 6 pagini si 5 clase cu teste. In cadrul paginilor am utilizat selectori cu ajutorul cssSelector, id, xPath.
Testele sunt descrise mai jos si am sa descriu flow-ul, scopul si daca am folosit ceva metode mai interesante.

DashboardTests.java
- searchSpecificEUIAndCheckIfIsDisplayCorrect
  Descriere: testul va deschide dropdonw-ul EUI si va selecta random un EUI. Intr-o variabila locala este stocat titlul EUI-ului.
  Scop: Scopul este de a verifica daca titlul afisat este gasit in dropdown. Ne intoarcem pe Dashboard si deschidem dropdown-ul din nou.
  Se extrag intr-o lista toate EUI-urile din dropdown si se verifica daca titlul stocat in variabila este prezent in lista.


LoginTests.java
- checkErrorForInvalidUser
  Descriere: aici am folosit polimorfismul apeland metoda login de pe pagina LoginPage.java.
  Scop: Scopul testului este de a verifica daca la logarea unui user inexistent este afisat un mesaj informativ correct pe pagina.
  Stiu ca se folosesc resurse mai multe pentru metoda de assert aleasa si puteam sa creez un selector pentru zona specifica unde se afla erroarea.



LogoutTests.java
- searchSpecificEUIAndCheckIfIsDisplayCorrect
  Descriere: Testul se logheaza si delogheaza.
  Scop: Acesta are ca scop verificarea URL-ului dupa delogare. Verifica afisarea paginii de login.



SortingTests.java
- checkSorting
  Descriere: In acest test se utilizeaza mai multe filtre dupa care se face o sortare.
  Scop: Testul are ca scop verificarea daca coloana sortata este sortata correct. Testul va parcurge toate paginile cu rezultate.
  Minusul neinclus in acest test este faptul ca daca se modifica volumul de date, testul va cadea. Stiu ca solutia este de a stoca numarul de pagini cu rezultate,
  si folosit in iterare.



TreeViewTests.java
- checkLegendTreeView
  Descriere: Testul deschide pagina de tree.
  Scop: Are ca scop verificarea Legendei. Intradevar testul nu verifica si pozitia acestora.



- checkStatusNone
  Descriere: Acest test verifica functionalitatea anumitor filtre de pe tree. Astfel ca dupa deschiderea tree-ului Critical, Warning si Normal vor fi excluse.
  Scop: Testul se asigura ca nu apare culoarea acestora pe pagina. Aici mai trebuiau incluse si alte culori - am folosit doar datele actuale. Iar alt minus
  este faptul ca daca nu exista rezultate pentru filtrarea selectata, testul va cadea. Puteam folosi un try catch probabil.




2. Form

Aici am folosit DataProvide pentru rularea si completarea formularelor.

3. Wikipedia

In aceasta parte a proiectului am lasat si ce am incercat sa fac. Initial in WikiTest am scris script-ul asa cum s-a cerut,
dar nu am reusit sa verific timpul de performanta in raport. Am lasat totusi acolo clasele prin care am incercat oarecum customizarea unui raport.

Partea functionala 100% din acest proiect este in WikiTests unde testele sunt scrise separat (nu utilizand DataProvider), iar raportul cu timpul de rulare pentru
fiecare test se poate deschide in browser din test-output -> emailable-report.html. Attachment-ul se efectueaza dupa assert si este stocat in package-ul screenshtos.
La fiecare rulare acestea se suprapun pentru a nu incarca memoria.
