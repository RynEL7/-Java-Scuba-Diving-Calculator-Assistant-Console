@echo off
color 1A
set enginefile="SDCalcEngine"
set uiconsolefile="ScubaDiving"

:mainmenu
echo      -------------------------------------------------------
echo      ::SCUBA DIVING CALCULATOR ASSISTANT SETUP FOR WINDOWS::
echo      ::Choose Which Setup To Perform::
echo      1.Make Class File
echo      2.Clean Class File
echo      3.Run File
echo      4.Exit
set /p menu="      choose : "
if %menu%==1 goto makefile
if %menu%==2 goto cleanfile
if %menu%==3 goto runfile
if %menu%==4 exit

if %menu% neq 1 goto chka
:chka
cls
if %menu% neq 2 goto chkb
:chkb
cls
if %menu% neq 3 goto chkc
:chkc
cls
if %menu% neq 4 goto mainmenu


:makefile
cls
echo      -------------------------------------------------------
echo      ::MAKING CLASSES FILE::
echo      Please wait...
javac %enginefile%.java
javac %uiconsolefile%.java
echo      ::MAKING CLASSES FILE SUCCESSFULL::
echo      -------------------------------------------------------

if %menu% neq 3 goto mainmenu
if %menu%==3 goto runfile

:cleanfile
cls
echo      -------------------------------------------------------
if exist "%enginefile%.class" del /q "%enginefile%.class"
if exist "%uiconsolefile%.class"  del/q "%uiconsolefile%.class" 
echo      ::DELETING SUCCESSFULL::
echo      -------------------------------------------------------
goto mainmenu

:runfile
cls
if exist "%enginefile%.class" goto a
:a
if exist "%uiconsolefile%.class" java ScubaDiving

if not exist "%enginefile%.class" goto b 
:b
if not exist "%uiconsolefile%.class" goto makefile