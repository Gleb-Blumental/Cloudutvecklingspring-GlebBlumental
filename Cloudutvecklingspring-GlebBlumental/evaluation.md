# Evaluation.md

## Inledning
I den här bedömningen tänker jag skriva det som har gått bra, det som kunde ha gått bättre och det som jag skulle göra helt annorlunda.

### Det som gick bra
Först och främst det som gick bra, tycker jag, är CRUD operationer, modeller, attributer och allt möjligt. Jag tycker att
jag lyckades lära mig REST-api som används på en lokal maskin, dock kan bli bättre när det används i applikation
som har frontend. Jag tycker att jag höll mig ok med tidsgränser, då började jag i god tid, gick in och läste själv ganska mycket
och försökte göra så mycket jag kan själv. Även om jag inte har lyckats helt. Det var också roligt att göra diagram.

### Det som kunde ha gått bättre
Det som kunde ha gått bättre är frontend - jag blev helt förvirrad om hur jag ska koppla den till mina controllers och 
hur jag ska undvika redirect loops, då jag stötte på detta problem väldigt mycket och det hindrade mig från att bli klar med
uppgiften. Jag la också ganska mycket tid på att lösa Cognito fel som jag hade först, då tog jag code-snippets som kunde
ha varit användbara i något annat fall, men var helt redundant nu. Med detta förvirrade jag mig själv ganska mycket och
stoppade arbetsprocessen i mindre grad. Sist så hade jag problem med att driftsätta applikationen, då tyckte jag att jag 
gör det när jag är halvklar med applikationen, så att den förvirrar inte mig när jag ska börja skriva på riktigt. Denna 
bedömningen blev felaktigt, då först det var Jenkins som fejlade på mig och jag fick byta driftsättningsmetoden sista
sekunden och sen funkade inte Pipeline heller, eftersom jag behövde ett godkännande från ägare av mitt GitHub repo, som 
inte var mig, så till slut kunde jag inte ens driftsätta applikationen som jag hoppades.

### Kritiskt analys
Jag tycker att från hela början så skulle jag skapa enkla klasser som models och repositories, sen skulle jag driftsätta
applikationen, eftersom då kan jag se mina uppdateringar i realtid och om att de funkar eller inte. Vidare tycker jag att
det är bättre om att jag skulle ha testat att Cognito funkar på riktigt innan jag börjar skriva alla metoder och webappens
funktioner, då det skulle bli färre saker att röra sig om och desto färre problem. Nu ska jag göra om halva applikationen 
för att någonting som jag inte vet, funkar inte med min frontend. Det som var bra är att jag äntligen fattade om hur Cognito
funkar och hur det kopplas till UI, eftersom jag hade svårt med det förra terminen, därmed så fattar jag bättre hur frontend 
funkar och kan snabbare ladda upp koden till AWS Pipeline och CodeDeploy och kontrollera dess arbete, som jag tycker också är bra.
Xray var också roligt att lära sig.
