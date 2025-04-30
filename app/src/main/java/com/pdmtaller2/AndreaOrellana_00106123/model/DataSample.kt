package com.pdmtaller2.AndreaOrellana_00106123.model

object DataSample {
    val restaurants = listOf(
        Restaurant(
            id = 1,
            name = "Pizza Planet",
            description = "Las mejores pizzas del universo",
            imageUrl = "https://static.wikia.nocookie.net/disney/images/d/d3/Pizza_Planet2.jpg/revision/latest/scale-to-width-down/1200?cb=20220806195017",
            categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
            menu = listOf(
                Dish(
                    id = 1,
                    name = "Pizza Pepperoni",
                    description = "Pizza saludable con pepperoni y queso",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI0-HmskFIOzX-o3_DTZdgLshMNluWvZpwAw&s"
                ),
                Dish(
                    id = 2,
                    name = "Pizza Vegetariana",
                    description = "Pizza Saludable con verduras frescas",
                    imageUrl = "https://www.revistapancaliente.co/wp-content/uploads/2024/09/Pizza_vegetariana.jpg"
                )
            )
        ),
        Restaurant(
            id = 2,
            name = "Burguer King Kong",
            description = "Las hamburguesas más monstruosas",
            imageUrl = "https://www.hispanidad.com/uploads/s1/19/54/34/burger-king-cierra-establecimientos-en-mexico-pero-abre-en-otros-paises-hispanoamericanos.jpeg",
            categories = listOf("Papas", "Hamburguesas", "Vegetariano"),
            menu = listOf(
                Dish(
                    id = 3,
                    name = "Hamburguesa DOble queso",
                    description = "Doble carne, doble queso, doble sabor",
                    imageUrl = "https://mcdonalds.com.sv/imagen/menu-products/1709140471_700x700_Queso_doble_te_alcanza.jpg"
                ),
                Dish(
                    id = 4,
                    name = "Hamburguesa Vegana",
                    description = "Una opcion deliciosa y saludable",
                    imageUrl = "https://delantaldealces.com/wp-content/uploads/2016/03/hamburguesa-vegana-garbanzos-tofu-4.jpg"
                )
            )
        ),
        Restaurant(
            id = 3,
            name = "Taco Loco",
            description = "Los tacos más locos y sabrosos",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTubZbzFfhgiFHYzPIkQk69cD555m5MqnNp3g&s",
            categories = listOf("Comida Mexicana", "Tacos"),
            menu = listOf(
                Dish(
                    id = 5,
                    name = "Tacos al Pastor",
                    description = "Con piña y cebolla, estilo CDMX",
                    imageUrl = "https://comedera.com/wp-content/uploads/sites/9/2017/08/tacos-al-pastor-receta.jpg"
                ),
                Dish(
                    id = 6,
                    name = "Tacos de Birria",
                    description = "Con consomé caliente y picante",
                    imageUrl = "https://www.mccormick.com/-/media/project/oneweb/mccormick-us/el-guapo/recipes/800x800/beef_birra_tacos_ground_black_pepper_800x800.jpg?rev=e42c1fb5716547f489920ad0e765427a&vd=20211208T213909Z&extension=webp&hash=EB7CE59B96A81D047EF25115F1FFEEA8"
                )
            )
        ),
        Restaurant(
            id = 4,
            name = "Sushi Express",
            description = "Frescura japonesa en minutos",
            imageUrl = "https://www.lagranvia.com.sv/storage/shops/hg4GEtoFSl0lfryjBeTfhrSnOZdHdxsWZQ8SV6yg.jpeg",
            categories = listOf("Comida Asiática", "Sushi"),
            menu = listOf(
                Dish(
                    id = 7,
                    name = "Sushi Roll Clásico",
                    description = "Arroz, pepino, aguacate y salmón fresco",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT94lUJUxJ330IswCB3Wig0MH1qFNfUAct1SQ&s"
                ),
                Dish(
                    id = 8,
                    name = "Tempura Roll",
                    description = "Crujiente y delicioso, con camarón frito",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNouJ2zSHfV1h_WoSkbVhi0aX5gs-Ahlo1cg&s"
                )
            )
        ),
        Restaurant(
            id = 5,
            name = "Green Bowl",
            description = "Comida saludable y sabrosa",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqwvoG_4F-4qxQIUFlqIfGLqOs0geu_So24w&s",
            categories = listOf("Comida Saludable", "Vegetariano", "Ensaladas"),
            menu = listOf(
                Dish(
                    id = 9,
                    name = "Bowl de Quinoa",
                    description = "Con aguacate, tomate y garbanzos",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBmqB8Ju3dHkpuw686hN6WqZ0gkGkolMBlrw&s"
                ),
                Dish(
                    id = 10,
                    name = "Ensalada César Vegana",
                    description = "Sin lácteos y con crutones de garbanzo",
                    imageUrl = "https://mejorconsalud.as.com/wp-content/uploads/2020/09/ensalada-cesar-vegana.jpg"
                )
            )
        )

    )

}