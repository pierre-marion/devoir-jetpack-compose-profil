
package com.example.developerprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.developerprofile.ui.theme.DeveloperProfileTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DeveloperProfileTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ProfileCard(
        name = "Pierre Marion",
        role = "Développeur Full-Stack",
        description = "Étudiant en Mastère architecture logiciel à l'ESGI. Passionné par le développement web, les interfaces modernes et les nouvelles technologies.",
        skills = listOf(
            "Angular",
            "TypeScript",
            "C# / .NET",
            "Node.js",
            "PostgreSQL"
        ),
        availability = "En alternance chez CGI",
        buttonText = "Voir mon portfolio",
        onProfileClick = {

        },
        onActionClick = {

        },
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

@Composable
fun ProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    availability: String,
    buttonText: String,
    onProfileClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = onProfileClick
            )
            .semantics {
                contentDescription = "Consulter le profil de $name"
            }
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            ProfileHeader(
                name = name,
                role = role,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileDescription(
                description = description,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            SkillsSection(
                skills = skills,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileAvailability(
                availability = availability,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProfileAction(
                buttonText = buttonText,
                onActionClick = onActionClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = role)
    }
}

@Composable
fun ProfileDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "À propos")
        Text(
            text = description,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun SkillsSection(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Compétences",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        for (skill in skills) {
            SkillItem(
                skill = skill,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "• $skill",
        modifier = modifier
    )
}

@Composable
fun ProfileAvailability(
    availability: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Situation actuelle")
        Text(
            text = availability,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ProfileAction(
    buttonText: String,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onActionClick,
        modifier = modifier
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun DeveloperProfilePreview() {
    DeveloperProfileTheme {
        ProfileScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun AndroidDeveloperPreview() {
    DeveloperProfileTheme {
        ProfileCard(
            name = "Alex Martin",
            role = "Développeur Android Junior",
            description = "Développeur passionné par la création d'applications mobiles avec Kotlin et Jetpack Compose.",
            skills = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Android Studio",
                "Git"
            ),
            availability = "Disponible pour un stage",
            buttonText = "Contacter",
            onProfileClick = {},
            onActionClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}
