package ru.project.calculator.operations;

/**
 * Список приоритетов операций
 */
public enum PriorityOfOperation {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6);

    private final int value;

    private PriorityOfOperation(int value) {
        this.value = value;
    }


    public boolean equals(PriorityOfOperation priority){
        return this.value==priority.value;
    }

    /**
     * Метод сравнения приоритетов операций:
     *  - -1 - приоритет ниже указанного в аргументе метода
     *  - 0  - приоритеты равны
     *  - 1  - приоритет выше указанного в аргументе метода
     *
     * @param priority
     * @return
     */
    public int comparePriorityTo(PriorityOfOperation priority){
        if (equals(priority))
            return 0;
        if (this.value<priority.value)
            return 1;
        else
            return -1;
    }
}
