# praktika-java

[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://musical-space-chainsaw-6x4xqxrvj4jf4v99.github.dev/)

---

## [Taska 1](https://github.com/1kalina/praktika-java/tree/main/1-taska/src/)

```Java
public class main 
{
    public static void main(String[] args) 
    {
        System.out.println("OS is running. GitHub is configured. Netbeans is up.");
    }
}
```

![result task 1](https://github.com/1kalina/praktika-java/blob/main/images/1-taska/result.png)

---

## [Taska 2](https://github.com/1kalina/praktika-java/tree/main/2-taska/src/ex02)
Підрахувати кількість чергувань 0 та 1 у двійковому поданні заданого десяткового числа.

![5 task 2](https://github.com/1kalina/praktika-java/blob/main/images/2-taska/5.png)

![9753 task 2](https://github.com/1kalina/praktika-java/blob/main/images/2-taska/9753.png)

![12345 task 2](https://github.com/1kalina/praktika-java/blob/main/images/2-taska/12345.png)

### Запитання для елементарного рівня
1. **Агрегація** (агрегування за посиланням) – зв’язок "частина-ціле", де обидва об’єкти можуть існувати окремо (наприклад, університет і студент).  
2. **Агрегація** – синонім першого поняття: слабке зв’язування, де життєвий цикл частини не залежить від цілого.  
3. **Композиція** (агрегування за значенням) – жорсткий зв’язок, коли частина не може існувати без цілого (при знищенні контейнера знищується і частина).  
4. **Делегування** – принцип, коли об’єкт передає виконання задач іншому об’єкту, зменшуючи зв’язність класів.  
5. **Серіалізація** – перетворення об’єкта у послідовність байтів для збереження чи передачі з можливістю відновлення (десеріалізації).  
6. При реалізації `Serializable`, JVM автоматично серіалізує всі не-`transient` поля, а десеріалізація створює новий об’єкт із відновленими даними.  
7. `Externalizable` вимагає ручної імплементації методів `writeExternal` та `readExternal` для повного контролю над процесом серіалізації.  
8. `Transient` поля не зберігаються; після десеріалізації вони отримують значення за замовчуванням (0, false, null).  
9. `Static` поля не серіалізуються, адже належать класу, а не об’єкту.  
10. **javadoc** – інструмент для генерації HTML-документації з Java-коду за допомогою спеціальних коментарів та тегів.

---

## [Taska 3](https://github.com/1kalina/praktika-java/tree/main/3-taska/src/ex02)

![5 task 3](https://github.com/1kalina/praktika-java/blob/main/images/3-taska/5.png)

![9753 task 3](https://github.com/1kalina/praktika-java/blob/main/images/3-taska/9753.png)

![12345 task 3](https://github.com/1kalina/praktika-java/blob/main/images/3-taska/12345.png)

---

## [Taska 4](https://github.com/1kalina/praktika-java/tree/main/4-taska/src/ex02)

![5 task 4](https://github.com/1kalina/praktika-java/blob/main/images/4-taska/5.png)

![9753 task 4](https://github.com/1kalina/praktika-java/blob/main/images/4-taska/9753.png)

![12345 task 4](https://github.com/1kalina/praktika-java/blob/main/images/4-taska/12345.png)

---

## [Taska 5](https://github.com/1kalina/praktika-java/tree/main/5-taska/src/ex02)

**Поправлене бінарне відображеня числа у відновлених даних**

List:

![5 list task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/5-list.png)

![9753 list task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/9753-list.png)

![12345 list task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/12345-list.png)


Table:

![5 table task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/5-table.png)

![9753 table task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/9753-table.png)

![12345 table task 5](https://github.com/1kalina/praktika-java/blob/main/images/5-taska/12345-table.png)

---

## [Taska 6](https://github.com/1kalina/praktika-java/tree/main/6-taska/src/ex06)

Відображається в довільному порядку через паралельність виконання. Яка задача швидше виконалась, результат тієї і виводиться на екран

![1 try](https://github.com/1kalina/praktika-java/blob/main/images/6-taska/1.png)

![2 try](https://github.com/1kalina/praktika-java/blob/main/images/6-taska/2.png)

![3 try](https://github.com/1kalina/praktika-java/blob/main/images/6-taska/3.png)
