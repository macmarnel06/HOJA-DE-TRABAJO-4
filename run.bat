@echo off
echo =========================================
echo    Compilando Evaluador Infix a Postfix
echo =========================================
if not exist "out" mkdir out
javac -source 8 -target 8 -d out src\main\java\com\calculator\*.java

if %errorlevel% neq 0 (
    echo.
    echo HUBIERO ERRORES DE COMPILACION.
    pause
    exit /b %errorlevel%
)

echo Compilacion exitosa.
echo.
echo =========================================
echo                   HDT4
echo =========================================
java -cp out com.calculator.App

echo.
pause