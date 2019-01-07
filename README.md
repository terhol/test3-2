# Test 3-1
Third test version 2 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)
Rozhraní ani předdefinované třídy neměňte, pokud to přímo nevyžaduje zadání. Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte zásadně privátní atributy.
Úloha simuluje prodej časopisů. Každý časopis má název a číslo vydání. Prodejna časopisů (rozhraní Vendor) si ke každému vydání časopisu pamatuje cenu (každé vydání může mít jinou cenu).

Zadání:

- Vytvořte externí komparátor, který bude časopisy třídit abecedně podle názvu a čísla vydání (vzestupně).
- Vytvořte třídu VendorImpl implementující rozhraní Vendor.
- Metody save() budou zapisovat do souboru informace o časopisech v pořadí daném komparátorem.
- Obě metody save() vyhodí výjimku IOException při jakékoliv chybě vstupu/výstupu!
Vyhněte se opakování kódu tím, že metoda save(String file) bude využívat/volat metodu save(OutputStream os).
Třída Demo by při správném řešení měla vypsat:
    - Pokus o vlozeni spatne ceny: OK
    - Nejdrazsi casopisy: [Nature /3/, Alarm Revue /1/]
    - Zapisuji do souboru vendor-out.txt...

a zároveň by měla v aktuálním adresáři, ze kterého se zpouští, vytvořit soubor vendor-out.txt s následujícím obsahem:

        ABC /1/: 9.0
            ABC /2/: 9.0
            ABC /3/: 9.0
            Alarm Revue /1/: 12.5
            Alarm Revue /2/: 10.0
            Alarm Revue /8/: 12.0
            Nature /3/: 12.5

## License
MIT