package ec.edu.uisek.githubclient

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewProjectForm(modifier: Modifier = Modifier) {
    var projectName by remember { mutableStateOf("") }
    var projectDescription by remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Crear nuevo repositorio",
                style = MaterialTheme.typography.titleMedium
            )

            OutlinedTextField(
                value = projectName,
                onValueChange = { projectName = it },
                label = { Text("Nombre del proyecto") },
                placeholder = { Text("ej. mi-proyecto-compose") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = projectDescription,
                onValueChange = { projectDescription = it },
                label = { Text("Descripción del proyecto") },
                placeholder = { Text("Breve descripción del propósito...") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

            Button(
                onClick = { /* Formulario visual sin acción de guardado */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Crear proyecto")
            }
        }
    }
}

@Composable
fun RepositoryItem(repository: Repository, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = repository.name,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = repository.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = repository.language,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Estrellas",
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.tertiary
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = repository.stars.toString(),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun RepositoryList(
    repositories: List<Repository>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            NewProjectForm()
        }

        item {
            Text(
                text = "Repositorios Públicos",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
            )
        }

        items(repositories, key = { it.id }) { repo ->
            RepositoryItem(repository = repo)
        }
    }
}