package com.kuba.comp.model.task1;

/*
Zaimplementować w języku Java abstrakcję klas drzewa liściastego i iglastego (chodzi model OOP zwykłych drzew występujących w środowisku naturalnym) - każde drzewo ma pień, gałęzie i liście oraz metodę rośnij i itp.
Zaimplementować bibliotekę kliencką obsługi faktur w systemie płatności Stripe (https://stripe.com/docs/api/invoices). W ramach zadania należy obsłużyć tworzenie i pobieranie faktur.
Wymagania implementacyjne:

opis rozwiązania w projekcie w pliku README.md,
testy jednostkowe rozwiązania,
obsługa logowania,
walidacja parametrów,
wykorzystanie spring boota 2.
 */

import java.util.List;

public abstract class Tree {
    protected Trunk trunk;
    protected List<Branch> branches;
    protected List<ILeaf> leaves;
    protected List<IFruit> fruits;

    public abstract void grow();

    public abstract void growFruit();
    public abstract void growLeaves();

    public abstract void produceOxygen();

    public abstract void shedLeaves();
    public abstract void dropFruits();

    public abstract void hibernate();
}
